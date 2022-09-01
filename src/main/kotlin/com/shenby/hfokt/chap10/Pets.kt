package com.shenby.hfokt.chap10

abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

/**
 * Vet:兽医
 * in:泛型是可以逆变的，就是可以用父类型来替换子类型；类似于JAVA泛型的下限 < ? super T>
 * 通常如果类的方法使用泛型类型作为参数类型，那么类或者接口的泛型可以使用in前缀；
 * 然而 如果类的方法使用泛型作为返回类型，或者泛型类型用于val或者var的属性，则不能使用in;
 * in:只能用于输入，如方法的参数等，但不能用于输出，如方法的返回值等
 */
class Vet<T : Pet> {
    /**
     * treat:治疗,处理
     */
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

class Contest<T : Pet>(var vet: Vet<in T>) {
    private val scores: MutableMap<T, Int> = mutableMapOf()

    /**
     * 添加评分
     */
    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) {
            //编译器推荐的写法
            //scores[t] = score
            scores.put(t, score)
        }
    }

    /**
     * 获取得分最高的一个，可能不止一个
     */
    fun getWinner(): MutableList<T> {
        val max = scores.values.max()
        val result = mutableListOf<T>()
        for ((t, score) in scores) {
            if (score == max) {
                result.add(t)
            }
        }
        return result
    }
}


/**
 * retailer:零售店
 * 泛型使用<out T>,相当于JAVA泛型的<? extends T>,设置了上限,而不仅仅是T，
 *  使T的子类对象可以赋给父类T声明的对象，实现了协变(可以用子类替换父类:多态)
 *  out:输出的意思，可以用于方法返回值，但不能用于"输入"，例如方法的参数值;
 *  也可以用于声明val的属性，但不能用在var属性
 */
interface Retailer<out T> {
    fun sell(): T
    //todo 协变类型T不能作为方法参数
//    fun myFunction(t:T){
//
//    }

}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("sell cat")
        return Cat("")
    }
}


class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("sell dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("sell fish")
        return Fish("")
    }
}

fun main() {
    val cat1 = Cat("蓝猫")
    val cat2 = Cat("加菲猫")
    val fish = Fish("大锦鲤")

    val catVet = Vet<Cat>()
    val fishVet = Vet<Fish>()
    val dogVet = Vet<Dog>()

    catVet.treat(cat1)
    catVet.treat(cat2)


    //使用父类替代子类的vet,实现了泛型的逆变
    val vet = Vet<Pet>()
    val dogContest = Contest<Dog>(vet)

    vet.treat(cat1)
    vet.treat(fish)


    val contest = Contest<Cat>(catVet)
    contest.addScore(cat1, 60)
    contest.addScore(cat2, 70)
    val topCat = contest.getWinner()
    println("cat contest winner is  ${topCat.first().name}")

    //所有的宠物都可以参加
    val petContest = Contest<Pet>(Vet())
    petContest.addScore(cat1, 60)
    petContest.addScore(cat2, 70)
    petContest.addScore(fish, 100)

    val topPet = petContest.getWinner()
    println("Pet contest winner is  ${topPet.first().name}")


    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catRetailer: Retailer<Cat> = CatRetailer()

    val fishRetailer = FishRetailer()
    //todo 如果没有使用<out >,下面一行将无法编译通过
    val petRetailer: Retailer<Pet> = catRetailer
    val pet: Pet = petRetailer.sell()

}

import io.reactivex.rxjava3.core.Observable

 fun main(args: Array<String>) {

     val source = Observable.just(100, 50, 250, 150)

     val total = source.sum1()
     println(total.blockingGet())  //prints: 550
 }

 fun Observable<Int>.sum1() =
       reduce(0) { total, next -> total + next }
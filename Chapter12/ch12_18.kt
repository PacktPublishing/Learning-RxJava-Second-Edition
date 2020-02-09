import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxkotlin3.subscribeBy
import io.reactivex.rxkotlin3.zipWith

fun main(args: Array<String>) {

 val numbers =
         Observable.just(180.0, 160.0, 140.0, 100.0, 120.0)

 val average = numbers.publish()
         .autoConnect(2)
         .let {
             val sum = it.reduce(0.0) { total, next -> total +
             next}
             val count = it.count()

             sum.zipWith(count) { s, c -> s / c }
         }

 average.subscribeBy(::println)
}
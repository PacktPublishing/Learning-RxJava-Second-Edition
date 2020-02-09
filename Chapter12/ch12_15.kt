import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxkotlin3.zipWith

fun main(args: Array<String>) {
 val strings = Observable.just("Alpha", "Beta", "Gamma", "Delta")
 val numbers = Observable.range(1,4)
 val zipped = strings.zipWith(numbers) { s, n -> "$s $n" }
 zipped.subscribe(::println)
}
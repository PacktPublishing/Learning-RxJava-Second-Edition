import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxkotlin3.subscribeBy

fun main(args: Array<String>) {

 Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
           .count()
           .subscribeBy ({ println("There are $it items") })
}
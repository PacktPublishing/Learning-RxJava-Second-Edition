import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    val statusObserver = PublishSubject.create<Long>()
    statusObserver.subscribe { println("Status Observer: $it") }

    Observable.interval(1, TimeUnit.SECONDS)
            .take(5)
            .publish()
            .autoConnect(2)
            .apply {
                subscribe(statusObserver)
            }
            .map { it * 100 }
            .subscribe {
                println("Main Observer: $it")
            }

    Thread.sleep(7000)
}
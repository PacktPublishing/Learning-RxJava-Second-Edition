 import io.reactivex.rxjava3.core.Observable

 fun main(args: Array<String>) {

     Observable.just("Alpha", "Beta", "Gama", "Delta", "Epsilon")
               .map { s -> s.length }
               .subscribe { i -> println(i) }
 }
import io.reactivex.rxjava3.core.Observable

 fun main(args: Array<String>) {

     val source = Observable.just("Alpha", "Beta", "Gama", "Delta", "Epsilon")

     val asSet = source.toSet()
     println(asSet.blockingGet())  //prints: [Delta, Alpha, Epsilon, Beta, Gama]
 }

 fun <T> Observable<T>.toSet() =
         collect({ HashSet<T>() }, { set, next -> set.add(next) })
         .map { it as Set<T> }
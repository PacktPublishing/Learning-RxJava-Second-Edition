# Learning RxJava, Second Edition
Learning RxJava, Second Edition, published by Packt


## Errata

* Page 54:
  _A given Maybe<T> emits 0 or 1 items. It will pass the possible emission to onSuccess(), and in either case, it will call onComplete() when done. Maybe.just() can be used to create a Maybe emitting a single item. Maybe.empty() creates a Maybe that emits nothing:_

  **should be**

  _A given Maybe<T> will only emit 0 or 1 emissions. If there is an emission, it will pass it to onSuccess(). Otherwise, it will call onComplete() when done. These events are mutually exclusive for Maybe, so onComplete() won’t be called after onSuccess()._

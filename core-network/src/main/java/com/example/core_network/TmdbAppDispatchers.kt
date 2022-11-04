package com.example.core_network

import javax.inject.Qualifier

/**
 * Created by Dede Dari Rahmadi on 05/11/22
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val tmdbAppDispatcher: TmdbAppDispatchers)

enum class TmdbAppDispatchers {
    IO
}
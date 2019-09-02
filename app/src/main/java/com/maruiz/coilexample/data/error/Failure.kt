package com.maruiz.coilexample.data.error

sealed class Failure {
    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}
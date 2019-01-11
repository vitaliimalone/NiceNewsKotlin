package com.vitaliimalone.nicenewskotlin.data.converters

import java.util.*

abstract class Converter<Input, Output> {

    abstract fun convert(input: Input): Output

    abstract fun convertBack(output: Output): Input

    fun convertList(inputs: List<Input>): List<Output> {
        val outputs = ArrayList<Output>()
        for (input in inputs) {
            outputs.add(convert(input))
        }
        return outputs
    }

    fun convertListBack(outputs: List<Output>): List<Input> {
        val inputs = ArrayList<Input>()
        for (output in outputs) {
            inputs.add(convertBack(output))
        }
        return inputs
    }
}

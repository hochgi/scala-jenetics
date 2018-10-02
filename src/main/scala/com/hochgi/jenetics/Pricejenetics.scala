package com.hochgi.jenetics

import java.util.function.{Function => JFunction}
import io.jenetics.BitChromosome
import io.jenetics.BitGene
import io.jenetics.Genotype
import io.jenetics.engine.Engine
import io.jenetics.engine.EvolutionResult
import io.jenetics.util.Factory

object Pricejenetics extends App {

  val eval: JFunction[Genotype[BitGene],Integer] = { gt =>
    Integer.valueOf(gt.getChromosome().asInstanceOf[BitChromosome].bitCount())
  }
  val gtf: Factory[Genotype[BitGene]] = Genotype.of(BitChromosome.of(10, 0.5))
  val engine: Engine[BitGene, Integer] = Engine.builder[BitGene,Integer](eval,gtf).build()

  val result: Genotype[BitGene] = engine.stream().limit(100).collect(EvolutionResult.toBestGenotype())
  println("Hello World:\n" + result)
}

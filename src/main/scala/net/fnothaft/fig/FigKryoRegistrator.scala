/**
 * Copyright 2015 Frank Austin Nothaft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.fnothaft.fig

import com.esotericsoftware.kryo.Kryo
import net.fnothaft.fig.avro._
import org.apache.spark.serializer.KryoRegistrator
import org.bdgenomics.adam.serialization.AvroSerializer
import org.bdgenomics.formats.avro.{ Genotype, Feature }

class FigKryoRegistrator extends KryoRegistrator {
  override def registerClasses(kryo: Kryo) {
    kryo.register(classOf[Genotype], new AvroSerializer[Genotype]())
    kryo.register(classOf[Feature], new AvroSerializer[Feature]())
    kryo.register(classOf[BindingSite], new AvroSerializer[BindingSite]())
    kryo.register(classOf[LabeledPromoter], new AvroSerializer[LabeledPromoter]())
    kryo.register(classOf[ModifiedBindingSite], new AvroSerializer[ModifiedBindingSite]())
  }
}

/*
 * Copyright 2013 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.real_logic.sbe;

import java.nio.ByteBuffer;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import uk.co.real_logic.sbe.examples.Car;
import uk.co.real_logic.sbe.examples.Model;
import uk.co.real_logic.sbe.generation.java.DirectBuffer;

public class CarBenchmark
{
    private static final byte[] AUDI = "AUDI".getBytes();
    private static final byte[] R8 = "R8".getBytes();
    private static final byte[] V8 = "V8".getBytes();
    
    
    @State(Scope.Thread)
    public static class MyState
    {
        Car car = new Car();
        DirectBuffer buffer = new DirectBuffer(ByteBuffer.allocateDirect(1024));
    }

    @GenerateMicroBenchmark
    public Car testMethod(MyState state)
    {
        state.car.reset(state.buffer, 0);
        
        state.car.code(Model.A);
        state.car.fuelFigures().mpg(35.6F);
        state.car.fuelFigures().speed(100);       
        state.car.modelYear(2005);
        state.car.performanceFigures().accelerationSize(10);
        state.car.performanceFigures().octaneRating((short) 98);
        state.car.putMake(AUDI, 0, AUDI.length);
        state.car.putModel(R8, 0, R8.length);
        state.car.engine().capacity(8000);
        state.car.engine().fuel(5);
        state.car.engine().putManufacturerCode(V8, 0, V8.length);
        state.car.engine().numCylinders((short) 8);
        
        return state.car;
    }
}

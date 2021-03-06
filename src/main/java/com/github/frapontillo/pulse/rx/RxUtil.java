/*
 * Copyright 2015 Francesco Pontillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.frapontillo.pulse.rx;

import rx.Observable;

/**
 * Utility RxJava methods.
 *
 * @author Francesco Pontillo
 */
public class RxUtil {

    /**
     * Custom {@link rx.Observable.Transformer} that flattens a sequence of {@link Observable} in a
     * single {@link Observable}.
     *
     * @param <T> Type parameter of the input/output object.
     *
     * @return {@link rx.Observable.Transformer} to be applied on sequences of {@link Observable}s.
     */
    public static <T> Observable.Transformer<Iterable<T>, T> flatten() {
        return observable -> observable.flatMapIterable(x -> x);
    }

}

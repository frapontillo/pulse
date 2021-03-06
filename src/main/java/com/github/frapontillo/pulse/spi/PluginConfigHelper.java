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

package com.github.frapontillo.pulse.spi;

import com.github.frapontillo.pulse.util.ISO8601DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.Date;

/**
 * Helper to convert {@link IPluginConfig} implementations from {@link JsonElement}s.
 *
 * @author Francesco Pontillo
 */
public class PluginConfigHelper {
    private static final Gson gson =
            new GsonBuilder().registerTypeAdapter(Date.class, new ISO8601DateDeserializer())
                             .create();

    /**
     * Build an instance of {@link IPluginConfig} from a {@link JsonElement}.
     *
     * @param json     The {@link JsonElement} to convert.
     * @param classOfT The class of the object to convert into.
     * @param <T>      The generic type of the object to convert into.
     *
     * @return An object of type {@link T} converted from the input JSON.
     */
    public static <T extends IPluginConfig> T buildFromJson(JsonElement json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}

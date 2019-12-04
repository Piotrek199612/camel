/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.nats;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;

public class NatsConsumerReplyToTest extends NatsTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint mockResultEndpoint;

    @Test
    public void testReplyTo() throws Exception {
        mockResultEndpoint.expectedBodiesReceived("World");
        mockResultEndpoint.expectedHeaderReceived(NatsConstants.NATS_SUBJECT, "test");

        template.sendBody("direct:send", "World");

        mockResultEndpoint.assertIsSatisfied();

        // grab reply message from the reply queue
        String out = consumer.receiveBody("nats://"  + getNatsUrl() + "?topic=myReplyQueue", 5000, String.class);
        assertEquals("Bye World", out);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:send")
                        .to("nats://"  + getNatsUrl() + "?topic=test&replySubject=myReplyQueue&flushConnection=true");

                from("nats://" + getNatsUrl() + "?topic=test&flushConnection=true")
                        .to(mockResultEndpoint)
                        .convertBodyTo(String.class)
                        .setBody().simple("Bye ${body}");
            }
        };
    }
}
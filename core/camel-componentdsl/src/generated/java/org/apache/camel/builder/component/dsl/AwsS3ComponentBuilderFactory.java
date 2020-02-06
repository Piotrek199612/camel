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
package org.apache.camel.builder.component.dsl;

import javax.annotation.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.aws.s3.S3Component;

/**
 * The aws-s3 component is used for storing and retrieving object from Amazon S3
 * Storage Service.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface AwsS3ComponentBuilderFactory {

    /**
     * AWS S3 Storage Service (camel-aws-s3)
     * The aws-s3 component is used for storing and retrieving object from
     * Amazon S3 Storage Service.
     * 
     * Category: cloud,file
     * Since: 2.8
     * Maven coordinates: org.apache.camel:camel-aws-s3
     */
    static AwsS3ComponentBuilder awsS3() {
        return new AwsS3ComponentBuilderImpl();
    }

    /**
     * Builder for the AWS S3 Storage Service component.
     */
    interface AwsS3ComponentBuilder extends ComponentBuilder<S3Component> {
        /**
         * The AWS S3 default configuration.
         * 
         * The option is a:
         * <code>org.apache.camel.component.aws.s3.S3Configuration</code> type.
         * 
         * Group: advanced
         */
        default AwsS3ComponentBuilder configuration(
                org.apache.camel.component.aws.s3.S3Configuration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * Amazon AWS Access Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default AwsS3ComponentBuilder accessKey(java.lang.String accessKey) {
            doSetProperty("accessKey", accessKey);
            return this;
        }
        /**
         * Amazon AWS Secret Key.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default AwsS3ComponentBuilder secretKey(java.lang.String secretKey) {
            doSetProperty("secretKey", secretKey);
            return this;
        }
        /**
         * The region where the bucket is located. This option is used in the
         * com.amazonaws.services.s3.model.CreateBucketRequest.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: common
         */
        default AwsS3ComponentBuilder region(java.lang.String region) {
            doSetProperty("region", region);
            return this;
        }
        /**
         * Whether the component should use basic property binding (Camel 2.x)
         * or the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AwsS3ComponentBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default AwsS3ComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: consumer
         */
        default AwsS3ComponentBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
    }

    class AwsS3ComponentBuilderImpl
            extends
                AbstractComponentBuilder<S3Component>
            implements
                AwsS3ComponentBuilder {
        @Override
        protected S3Component buildConcreteComponent() {
            return new S3Component();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "configuration": ((S3Component) component).setConfiguration((org.apache.camel.component.aws.s3.S3Configuration) value); return true;
            case "accessKey": ((S3Component) component).setAccessKey((java.lang.String) value); return true;
            case "secretKey": ((S3Component) component).setSecretKey((java.lang.String) value); return true;
            case "region": ((S3Component) component).setRegion((java.lang.String) value); return true;
            case "basicPropertyBinding": ((S3Component) component).setBasicPropertyBinding((boolean) value); return true;
            case "lazyStartProducer": ((S3Component) component).setLazyStartProducer((boolean) value); return true;
            case "bridgeErrorHandler": ((S3Component) component).setBridgeErrorHandler((boolean) value); return true;
            default: return false;
            }
        }
    }
}
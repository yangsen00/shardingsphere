/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.singletable.rule.builder;

import org.apache.shardingsphere.infra.config.props.ConfigurationProperties;
import org.apache.shardingsphere.infra.config.props.ConfigurationPropertyKey;
import org.apache.shardingsphere.infra.rule.ShardingSphereRule;
import org.apache.shardingsphere.infra.rule.builder.schema.DatabaseRuleBuilder;
import org.apache.shardingsphere.infra.rule.builder.schema.DatabaseRuleBuilderFactory;
import org.apache.shardingsphere.infra.rule.identifier.scope.DatabaseRule;
import org.apache.shardingsphere.singletable.config.SingleTableRuleConfiguration;
import org.apache.shardingsphere.singletable.rule.SingleTableRule;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public final class SingleTableRuleBuilderTest {
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void assertBuild() {
        Collection<DatabaseRuleBuilder> builders = DatabaseRuleBuilderFactory.getInstances();
        DatabaseRuleBuilder builder = builders.iterator().next();
        SingleTableRuleConfiguration config = mock(SingleTableRuleConfiguration.class);
        ShardingSphereRule shardingSphereRule = mock(ShardingSphereRule.class);
        DatabaseRule databaseRule = builder.build(config, "", Collections.emptyMap(), Collections.singletonList(shardingSphereRule), new ConfigurationProperties(createProperties()));
        assertThat(databaseRule, instanceOf(SingleTableRule.class));
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void assertBuildWithDefaultDataSource() {
        ShardingSphereRule shardingSphereRule = mock(ShardingSphereRule.class);
        Collection<DatabaseRuleBuilder> builders = DatabaseRuleBuilderFactory.getInstances();
        DatabaseRuleBuilder builder = builders.iterator().next();
        SingleTableRuleConfiguration config = new SingleTableRuleConfiguration();
        config.setDefaultDataSource("ds_0");
        DatabaseRule databaseRule = builder.build(config, "", Collections.emptyMap(), Collections.singletonList(shardingSphereRule), new ConfigurationProperties(createProperties()));
        assertThat(databaseRule, instanceOf(SingleTableRule.class));
    }
    
    private Properties createProperties() {
        Properties result = new Properties();
        result.setProperty(ConfigurationPropertyKey.CHECK_DUPLICATE_TABLE_ENABLED.getKey(), Boolean.FALSE.toString());
        return result;
    }
}

/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.core.rule;

import io.shardingsphere.core.constant.PoolType;
import io.shardingsphere.core.constant.transaction.ProxyPoolType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Data source parameters.
 *
 * @author zhangyonglun
 * @author panjuan
 */
@Getter
@Setter
public final class DataSourceParameter {
    
    private PoolType originPoolType;
    
    private ProxyPoolType proxyDatasourceType = ProxyPoolType.VENDOR;
    
    private String url;
    
    private String username;
    
    private String password;
    
    private boolean autoCommit;
    
    private long connectionTimeout;
    
    private long idleTimeout;
    
    private long maxLifetime;
    
    private int maximumPoolSize;
}

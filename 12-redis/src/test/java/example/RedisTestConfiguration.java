/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author Thomas Darimont
 */
@SpringBootApplication
public class RedisTestConfiguration {

	@Autowired RedisConnectionFactory factory;

	// @Bean
	// RedisConnectionFactory redisConnectionFactory() {
	// return new LettuceConnectionFactory();
	// }
	//
	// @Bean
	// RedisOperations<String, String> redisOperations(RedisConnectionFactory rcf) {
	//
	// RedisTemplate<String, String> rt = new RedisTemplate<>();
	// rt.setConnectionFactory(rcf);
	// rt.setKeySerializer(new StringRedisSerializer());
	// rt.setValueSerializer(new StringRedisSerializer());
	//
	// return rt;
	// }

	/**
	 * Clear database before shut down.
	 */
	@PreDestroy
	public void flushTestDb() {
		factory.getConnection().flushDb();
	}
}

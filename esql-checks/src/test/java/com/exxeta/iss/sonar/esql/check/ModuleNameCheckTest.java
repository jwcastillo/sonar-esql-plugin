/*
 * Sonar ESQL Plugin
 * Copyright (C) 2013-2017 Thomas Pohl and EXXETA AG
 * http://www.exxeta.com
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
package com.exxeta.iss.sonar.esql.check;

import java.io.File;

import org.junit.Test;

import com.exxeta.iss.sonar.esql.checks.verifier.EsqlCheckVerifier;

public class ModuleNameCheckTest {
	@Test
	public void test() throws Exception {
		ModuleNameCheck check = new ModuleNameCheck();

		EsqlCheckVerifier.issues(check, new File("src/test/resources/moduleName.esql"))
				.next()
				.atLine(1)
				.withMessage(
						"Rename module \"Badly_Named_Module\" to match the regular expression ^[A-Z][a-zA-Z0-9]{1,30}$.")
				.next()
				.atLine(4)
				.withMessage(
						"Rename module \"too_long_module_name_because_it_has_more_than_30_characters\" "
								+ "to match the regular expression ^[A-Z][a-zA-Z0-9]{1,30}$.")
				.noMore();
	}
}

/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.homeworks.homework16

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso.Builder
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.KakaoCompose.Override.useUnmergedTree
import org.junit.Rule
import org.junit.Test

class MainScreenListsTest: TestCase(Builder.withComposeSupport()) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    val mainScreenLists = MainScreenLists(composeTestRule)

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun lazyVerticalListTest() {
        before {
        }.after {
            mainScreenLists {
                lazyVerticalList.performScrollToNode(lazyHorizontalList.semanticsMatcher)
                lazyHorizontalList {
                    performScrollToIndex(1)
                    childAt<LazyListItemNode>(1) {
                        performClick()
                    }
                }
            }
        }.run {
            mainScreenLists {
                lazyHorizontalList {
                    performScrollToIndex(1)
                    childAt<LazyListItemNode>(1) {
                        performClick()
                    }
                }
                lazyVerticalList {
                    useUnmergedTree = true
                    performScrollToIndex(0)
                    childAt<LazyVerticalListNode>(0) {
                        performScrollTo()
                        assertIsDisplayed()
                        title {
                            assertIsDisplayed()
                            assertTextEquals("Deep Links Crash Course: Part 4 - Deep links for your business")
                        }
                    }
                }
            }
        }
    }
}
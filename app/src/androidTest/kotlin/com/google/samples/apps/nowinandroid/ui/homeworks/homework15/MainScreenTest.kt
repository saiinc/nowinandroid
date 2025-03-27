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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso.Builder
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.KakaoCompose.Override.useUnmergedTree
import io.github.kakaocup.compose.node.element.KNode
import org.junit.Rule
import org.junit.Test

class MainScreenTest: TestCase(Builder.withComposeSupport()) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    val mainScreen = MainScreen(composeTestRule)
    val kSearchScreen = KSearchScreen(composeTestRule)

    //@get:Rule
    //val kakaoComposeTestRule = KakaoComposeTestRule(    )


    @Test
    fun checkButtonText() {
        run {
            step("Check button") {
                mainScreen {
                    doneButton.assertTextContains("Done")
                }
            }
        }
    }

    @Test
    fun topBarCheck() {
        run {
            step("Top Bar Title check") {
                mainScreen.topBarTitle.assertTextEquals("Now in Android")
            }
            step("Top Bar Navigation Icon check") {
                mainScreen.topBarNavigationIcon.perform {
                    assertIsDisplayed()
                    assertContentDescriptionEquals("Search")
                }
            }
            step("Top Bar Action Icon check") {
                mainScreen.topBarActionIcon.perform {
                    assertIsDisplayed()
                    assertContentDescriptionEquals("Settings")
                }
            }
        }
    }

    @Test
    fun staticContentCheck() {
        run {
            step("Header check") {
                mainScreen.forYouInterestsItemHeader.assertTextEquals("What are you interested in?")
            }
            step("Subtitle check") {
                mainScreen.forYouInterestsItemSubtitle.assertTextEquals("Updates from topics you follow will appear here. Follow some things to get started.")
            }
            step("Done Button Check") {
                mainScreen {
                    useUnmergedTree = true
                        doneButton {
                        assertHasClickAction()
                        val childNode: KNode = this.child {
                            hasText("Done")
                        }
                        childNode.assertExists()
                    }
                }
            }
        }
    }

    @Test
    fun bottomNavBarTest() {
        run {
            mainScreen.bottomNavBar.assertIsDisplayed()
        }
    }

    @Test
    fun searchScreenTest() {
        run {
            mainScreen.topBarNavigationIcon.performClick()
            kSearchScreen.backButton {
                assertHasClickAction()
                assertIsDisplayed()
            }
            kSearchScreen.searchBarSearchIcon {
                assertIsDisplayed()
                assertContentDescriptionEquals("Search")
            }
            kSearchScreen.searchField {
                assertIsDisplayed()
                performTextInput("aaa")
            }
            kSearchScreen.trailingIconClose {
                assertIsDisplayed()
                assertContentDescriptionEquals("Clear search text")
            }
            kSearchScreen.recentSearches.assertTextEquals("Recent searches")
        }
    }
}
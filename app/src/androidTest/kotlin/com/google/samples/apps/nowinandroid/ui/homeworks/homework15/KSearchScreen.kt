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

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class KSearchScreen(semanticsProvider: SemanticsNodeInteractionsProvider) : ComposeScreen<MainScreen>(semanticsProvider) {
    val backButton: KNode = child {
        hasTestTag(C.back_Button)
        useUnmergedTree = true
    }

    val searchBarSearchIcon: KNode = child {
        hasTestTag(C.search_Bar_Search_Icon)
        useUnmergedTree = true
    }

    val searchField: KNode = child {
        hasTestTag("searchTextField")
        useUnmergedTree = true
    }

    val trailingIconClose: KNode = child {
        hasTestTag(C.trailing_Icon_Close)
        useUnmergedTree = true
    }

    val recentSearches: KNode = child {
        hasTestTag(C.recent_Searches)
        useUnmergedTree = true
    }
}
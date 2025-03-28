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

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.C
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class MainScreenLists(semanticsProvider: SemanticsNodeInteractionsProvider) : ComposeScreen<MainScreenLists>(semanticsProvider) {

    val lazyHorizontalList = KLazyListNode(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag("forYou:topicSelection") },
        itemTypeBuilder = {
            itemType(::LazyListItemNode)
        },
        positionMatcher = { position ->
            SemanticsMatcher.expectValue(
                LazyListItemPositionSemantics,
                position
            )
        },
        lengthSemanticsPropertyKey = LazyListLengthSemantics
    )

    val lazyVerticalList = KLazyListNode(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag("forYou:feed") },
        itemTypeBuilder = {
            itemType(::LazyVerticalListNode)
        },
        positionMatcher = { position ->
            SemanticsMatcher.expectValue(
                LazyListItemPositionSemantics,
                position
            )
        },
        lengthSemanticsPropertyKey = LazyListLengthSemantics
    )
}

class LazyListItemNode(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider,
) : KLazyListItemNode<LazyListItemNode>(semanticsNode, semanticsProvider) {
    val topicIcon: KNode = child {
        hasTestTag(C.lazy_List_Horisontal_Item_Topic_Icon)
    }
    val text: KNode = child {
        hasTestTag(C.lazy_List_Horisontal_Item_Text)
    }
    val toggleButton: KNode = child {
        hasTestTag(C.lazy_List_Horisontal_Item_Toggle)
    }
}

class LazyVerticalListNode(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider,
) : KLazyListItemNode<LazyVerticalListNode>(semanticsNode, semanticsProvider) {
    val title: KNode = child {
        hasTestTag(C.lazy_List_Header_Title)
    }
    val metadata: KNode = child {
        hasTestTag(C.lazy_List_Item_Metadata)
    }
    val content: KNode = child {
        hasTestTag(C.lazy_List_Item_Content)
    }
}
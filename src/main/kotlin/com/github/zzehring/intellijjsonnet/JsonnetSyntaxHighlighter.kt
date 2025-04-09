package com.github.zzehring.intellijjsonnet

import com.github.zzehring.intellijjsonnet.psi.JsonnetTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JsonnetSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return JsonnetLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            JsonnetTypes.BLOCK_COMMENT -> {
                COMMENT_KEYS
            }
            JsonnetTypes.LINE_COMMENT -> {
                COMMENT_KEYS
            }
            JsonnetTypes.PLUS, JsonnetTypes.MINUS, JsonnetTypes.EQUAL, JsonnetTypes.GREATER_EQUAL, JsonnetTypes.GREATER_THAN, JsonnetTypes.DOUBLE_GREATER, JsonnetTypes.EXCLAMATION -> {
                OPERATOR_KEYS
            }
            JsonnetTypes.L_BRACKET, JsonnetTypes.R_BRACKET -> {
                KEYWORD_BRACKET_KEYS
            }
            JsonnetTypes.L_CURLY, JsonnetTypes.R_CURLY -> {
                KEYWORD_BRACES_KEYS
            }
            JsonnetTypes.L_PAREN, JsonnetTypes.R_PAREN -> {
                KEYWORD_PARENTHESES_KEYS
            }
            JsonnetTypes.SEMICOLON -> {
                KEYWORD_SEMICOLON_KEYS
            }
            JsonnetTypes.COMMA -> {
                KEYWORD_COMMA_KEYS
            }
            JsonnetTypes.TRUE, JsonnetTypes.FALSE, JsonnetTypes.NULL, JsonnetTypes.IMPORT, JsonnetTypes.IMPORTSTR, JsonnetTypes.LOCAL, JsonnetTypes.FUNCTION, JsonnetTypes.IN, JsonnetTypes.IF, JsonnetTypes.THEN, JsonnetTypes.ELSE, JsonnetTypes.SUPER, JsonnetTypes.ERROR, JsonnetTypes.SELF, JsonnetTypes.FOR, JsonnetTypes.ASSERT, JsonnetTypes.DOLLAR -> {
                KEYWORD_KEYS
            }
            JsonnetTypes.NUMBER -> {
                NUMBER_KEYS
            }
            JsonnetTypes.SINGLE_QUOTED_STRING, JsonnetTypes.DOUBLE_QUOTED_STRING, JsonnetTypes.VERBATIM_DOUBLE_QUOTED_STRING, JsonnetTypes.VERBATIM_SINGLE_QUOTED_STRING, JsonnetTypes.TRIPLE_BAR_QUOTED_STRING -> {
                STRING_KEYS
            }
            TokenType.BAD_CHARACTER -> {
                BAD_CHAR_KEYS
            }
            else -> {
                EMPTY_KEYS
            }
        }
    }

    companion object {
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("JSONNET_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val KEY = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE = TextAttributesKey.createTextAttributesKey("JSONNET_VALUE", DefaultLanguageHighlighterColors.STRING)
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("JSONNET_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val NUMBER =
            TextAttributesKey.createTextAttributesKey("JSONNET_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val KEYWORD_COMMA = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.COMMA)
        val KEYWORD_SEMICOLON = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.SEMICOLON)
        val KEYWORD_PARENTHESES = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.PARENTHESES)
        val KEYWORD_BRACES = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.BRACES)
        val KEYWORD_BRACKET = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.BRACKETS)
        val OPERATOR_SIGN = TextAttributesKey.createTextAttributesKey("JSONNET_KEY", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val STATIC_FIELD = TextAttributesKey.createTextAttributesKey("JSONNET_STATIC_FIELD", DefaultLanguageHighlighterColors.STATIC_FIELD)
        val PARAMETER = TextAttributesKey.createTextAttributesKey("JSONNET_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val KEYWORD_KEYS = arrayOf(KEY)
        private val STRING_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val KEYWORD_COMMA_KEYS = arrayOf(KEYWORD_COMMA)
        private val KEYWORD_SEMICOLON_KEYS = arrayOf(KEYWORD_SEMICOLON)
        private val KEYWORD_PARENTHESES_KEYS = arrayOf(KEYWORD_PARENTHESES)
        private val KEYWORD_BRACES_KEYS = arrayOf(KEYWORD_BRACES)
        private val KEYWORD_BRACKET_KEYS = arrayOf(KEYWORD_BRACKET)
        private val OPERATOR_KEYS = arrayOf(OPERATOR_SIGN)
    }
}
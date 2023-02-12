module.exports = {
  parser: '@typescript-eslint/parser',
  parserOptions: {
    sourceType: 'module',
  },
  plugins: ['@typescript-eslint', 'react-hooks'],
  rules: {
    'no-unused-vars': 'off',
    'import/no-unresolved': 'off',
    'no-console': 'off',
    'no-shadow': 'off',
    'no-use-before-define': [0],
    'no-param-reassign': 'off',
    'react/no-danger': 'off',
    'react-hooks/rules-of-hooks': 'error',
    'react/no-array-index-key': 'warn',
    'react/jsx-props-no-spreading': 'off',
    'react/jsx-wrap-multilines': 'off',
    'react/require-default-props': 'off',
    'no-restricted-syntax': 'off',
    'react/jsx-uses-react': 'off',
    'import/prefer-default-export': 'off',
    '@typescript-eslint/no-unused-vars': 'off',
    '@typescript-eslint/no-explicit-any': 'off',
    '@typescript-eslint/no-use-before-define': 'off',
    'react/jsx-filename-extension': [
      2,
      { extensions: ['.js', '.jsx', '.ts', '.tsx', '.scss'] },
    ],
    'react/jsx-one-expression-per-line': 'off',
    'react-hooks/exhaustive-deps': [
      'warn',
      {
        enableDangerousAutofixThisMayCauseInfiniteLoops: true,
      },
    ],
    'react/jsx-indent': 'warn',
    'import/no-extraneous-dependencies': ['error', { devDependencies: true }],
    'import/extensions': ['off'],
    '@typescript-eslint/explicit-module-boundary-types': 'off',
    'prettier/prettier': ['error', { endOfLine: 'auto' }],
    'react/react-in-jsx-scope': 'off',
    'jsx-a11y/label-has-associated-control': [
      'error',
      {
        labelComponents: ['CustomLabel'],
        labelAttributes: ['inputLabel'],
        controlComponents: ['CustomInput'],
        assert: 'both',
        depth: 3,
        required: {
          some: ['nesting', 'id'],
        },
      },
    ],
    'jsx-a11y/label-has-for': [
      'error',
      {
        required: {
          some: ['nesting', 'id'],
        },
      },
    ],
  },
  extends: [
    'prettier',
    'airbnb',
    'airbnb/hooks',
    'plugin:@typescript-eslint/recommended',
    'plugin:prettier/recommended',
  ],
  settings: {
    'import/resolver': {
      node: { extensions: ['.js', '.jsx', '.ts', '.tsx', '.scss'] },
    },
  },
};

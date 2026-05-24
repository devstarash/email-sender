project = 'email-sender'
copyright = '2026, Nikita Starashchuk'
author = 'Nikita Starashchuk'
release = '1.0.0'

extensions = [
    "myst_parser",
]

source_suffix = {
    ".md": "markdown",
    ".rst": "restructuredtext",
}

templates_path = ['_templates']
exclude_patterns = []

html_theme = 'sphinx_rtd_theme'
html_static_path = ['_static']
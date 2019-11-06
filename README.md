# boolean-expression-evaluator
[![Build Status](https://travis-ci.com/rifttech/boolean-expression-evaluator.svg?branch=master)](https://travis-ci.com/rifttech/boolean-expression-evaluator)

## Unrary Operators
| Operation name | Operator | Notation |Precedence
| :---         |     :---:      |    :---:      |   :---:      |
| [Logical negation](https://en.wikipedia.org/wiki/Logical_negation)   | ```NOT```     | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\neg" title="\neg" />|1

## Binary Operators

| Operation name | Operator | Notation |Precedence
| :---         |     :---:      |    :---:      |   :---:      |
| [Logical conjunction](https://en.wikipedia.org/wiki/Logical_conjunction)   | ```AND```     | <img src="https://latex.codecogs.com/svg.latex?\Large&space;\land" title="\land" />|2
| [Logical disjunction](https://en.wikipedia.org/wiki/Logical_disjunction)     | ```OR```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\lor" title="\lor" />|3
| [Logical nor](https://en.wikipedia.org/wiki/Logical_NOR)     | ```NOR```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\downarrow" title="\downarrow" />|3|
| [Logical nand](https://en.wikipedia.org/wiki/Logical_NAND)     | ```NAND```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\uparrow" title="\uparrow" />|2|
| [Exclusive disjunction](https://en.wikipedia.org/wiki/Exclusive_disjunction)     | ```XOR```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\oplus" title="\oplus" />|3
| [Logical biconditional](https://en.wikipedia.org/wiki/Logical_biconditional)     | ```XNOR```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\leftrightarrow" title="\leftrightarrow" />|4
| [Material implication](https://en.wikipedia.org/wiki/Material_conditional)     | ```IMPL```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\rightarrow" title="\rightarrow" />|4|
| [Converse implication](https://en.wikipedia.org/wiki/Converse_implication)     | ```CIMPL```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\leftarrow" title="\leftarrow" />|4|
| [Material nonimplication](https://en.wikipedia.org/wiki/Material_nonimplication)     | ```NIMPL```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\nrightarrow" title="\nrightarrow" />|4|
| [Converse nonimplication](https://en.wikipedia.org/wiki/Converse_nonimplication)     | ```CNIMPL```      |<img src="https://latex.codecogs.com/svg.latex?\Large&space;\nleftarrow" title="\nleftarrow" />|4|


## Truth Tables

### Logical Conjunction

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> |<img src="https://latex.codecogs.com/svg.latex?\Large&space;P\land%20Q" title="\land" /> |
|------|------|-----|
| TRUE | TRUE | TRUE
| TRUE | FALSE | FALSE
| FALSE | TRUE | FALSE
| FALSE | FALSE | FALSE

### Logical Disjunction

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\lor%20Q" title="\land" /> |
|------|------|-----|
| TRUE | TRUE | TRUE
| TRUE | FALSE | TRUE
| FALSE | TRUE | TRUE
| FALSE | FALSE | FALSE

### Logical NOR

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\downarrow%20Q" title="\downarrow" /> |
|------|------|-----|
| TRUE | TRUE | FALSE
| TRUE | FALSE | FALSE
| FALSE | TRUE | FALSE
| FALSE | FALSE | TRUE


### Logical NAND

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\uparrow%20Q" title="\uparrow" /> |
|------|------|-----|
| TRUE | TRUE | FALSE
| TRUE | FALSE | TRUE
| FALSE | TRUE | TRUE
| FALSE | FALSE | TRUE


### Logical XOR

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\oplus%20Q" title="\oplus" /> |
|------|------|-----|
| TRUE | TRUE | FALSE
| TRUE | FALSE | TRUE
| FALSE | TRUE | TRUE
| FALSE | FALSE | FALSE



### Logical XNOR

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\leftrightarrow%20Q" title="\leftrightarrow" /> |
|------|------|-----|
| TRUE | TRUE | TRUE
| TRUE | FALSE | FALSE
| FALSE | TRUE | FALSE
| FALSE | FALSE | TRUE


### Material Implication

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\rightarrow%20Q" title="\leftarrow" />|
|------|------|-----|
| TRUE | TRUE | TRUE
| TRUE | FALSE | FALSE
| FALSE | TRUE | TRUE
| FALSE | FALSE | TRUE


### Converse Implication

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\leftarrow%20Q" title="\leftarrow" /> |
|------|------|-----|
| TRUE | TRUE | TRUE
| TRUE | FALSE | TRUE
| FALSE | TRUE | FALSE
| FALSE | FALSE | TRUE



### Material Nonimplication (Abjunction)

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\nrightarrow%20Q" title="\nrightarrow" /> |
|------|------|-----|
| TRUE | TRUE | FALSE
| TRUE | FALSE | TRUE
| FALSE | TRUE | FALSE
| FALSE | FALSE | FALSE


### Converse Nonimplication

| <img src="https://latex.codecogs.com/svg.latex?\Large&space;P" title="P" />  | <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q" title="Q" /> | <img src="https://latex.codecogs.com/svg.latex?\Large&space;P\nleftarrow%20Q" title="\nleftarrow" /> |
|------|------|-----|
| TRUE | TRUE | FALSE
| TRUE | FALSE | TRUE
| FALSE | TRUE | FALSE
| FALSE | FALSE | FALSE

## Code generation

You can generate parser with ```mvn clean compile``` command

- use ```-Pjava``` maven profile (uses by default) for java
- use ``-Pjs`` maven profile for
javascript


# SentimentAnalysis

Este programa es una pequeña muestra de un clasificador de frases (según sean positivas o negativas). Para ello hemos utilizado el teorema de Bayes con la finalidad de medir la probabilidad de aparición de las palabras en frases positivas o negativas. 
Mediante el uso de tres sets distintos de frases para el entrenamiento y posterior testeo, se ha logrado conseguir un porcentage elevado de aciertos. Aunque este test se puede probar con otras bases de datos con el mismo formato que las usadas para el testeo.


Esta versión del programa incluye una mejora que tiene en cuenta las negaciones, por ejemplo: 

I don't like this movie. / I do not like this movie. 

-> A partir de la negación (n't o not) sólo tendremos en cuenta los porcentajes contrarios a la palabra
seguida de la negación, es decir, "like", como palabra usualmente positiva, pasaría a contar sólo su
porcentje negativo junto con las palabras que le siguieran hasta un "." o ",".

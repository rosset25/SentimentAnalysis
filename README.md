# SentimentAnalysis

Este programa es una pequeña muestra de un clasificador de frases (según sean positivas o negativas). 
Para ello hemos utilizado el teorema de Bayes para medir la probabilidad de las palabras en frases
positivas o negativas. 
Mediante el uso de tres sets distintos de frases para el entrenamiento y poesterior testeo, se ha 
logrado conseguir un porcentage elevado de aciertos. 

NOTA: Esta versión del programa incluye una mejora que tiene en cuenta las negaciones, por ejemplo:
I don't like this movie. / I do not like this movie. 
-> A partir de la negación (n't o not) sólo tendremos en cuenta los porcentajes contrarios a la palabra
seguida de la negación, es decir, "like", como palabra usualmente positiva, pasaría a contar sólo su
porcentje negativo junto con las palabras que le siguieran hasta un "." o ",".

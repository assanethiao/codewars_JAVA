"""
How this cipher works
It looks at the letter, and sees it's index in the alphabet, the alphabet being a-z, if you didn't know.
If it is odd, it is replaced with 1, if it's even, its replaced with 0. Note that the index should start from 0.
Also, if the character isn't a letter, it remains the same.

Example
encode("Hello World!"); // => "10110 00111!"
This is because H's index is 7, which is odd, so it is replaced by 1, and so on.

"""

def encode(s):
    maj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    minis = "abcdefghijklmnopqrstuvwxyz"
    espace = " "
    resultat = ""

    for i in s:
        found = False  

        # Vérifie si la lettre est en majuscule
        for index1, j in enumerate(maj):
            if i == j:
                resultat += "1" if index1 % 2 == 1 else "0"
                found = True
                break  

        # Vérifie si la lettre est en minuscule
        if not found:
            for index2, k in enumerate(minis):
                if i == k:
                    resultat += "1" if index2 % 2 == 1 else "0"
                    found = True
                    break

        # Si ce n'est pas une lettre, on l'ajoute tel quel
        if not found:
            resultat += i

    return resultat

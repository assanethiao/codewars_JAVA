/*
You are given a node that is the beginning of a linked list. This list contains a dangling piece and a loop.
Your objective is to determine the length of the loop.
For example in the following picture the size of the dangling piece is 3 and the loop size is 12:

Use the `getNext()` method to get the following node.
node.getNext()
*/

public class LoopInspector {

  public int loopSize(Node node) {
    Node slow = node;
    Node fast = node;

    // Étape 1 : Détecter la boucle (rencontre des deux pointeurs)
    do {
      slow = slow.getNext();           // Avance de 1
      fast = fast.getNext().getNext(); // Avance de 2
    } while (slow != fast);

    // Étape 2 : Mesurer la taille de la boucle
    int loopLength = 1;
    Node current = slow.getNext();
    while (current != slow) {
      loopLength++;
      current = current.getNext();
    }

    return loopLength;
  }
}

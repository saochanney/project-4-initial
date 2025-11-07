This is my first prompt attempt for the AI:
    A Container interface has already been created and is as follows:
public interface Container<E> extends Iterable<E> {
void add(E item);
boolean remove(E item);
boolean contains(E item);
int size();
boolean isEmpty();
}
I need a generic class called Bag that implements the Container interface above.
I need the Bag inplementation to use ArrayList as the backing data structure.

-This is the first attempt for AI prompt for test class.
Generate a test class for my Bag implementation. I need the test to cover edge cases, normal operations, and iterator functionality.

-This is the first attempt at the implementation extra credit:
For the iterator of the test class, implement a forEach and a spliterator method.
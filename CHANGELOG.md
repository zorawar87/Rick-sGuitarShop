# v1.1 Introducing Mandolins #
  * Modify `Guitar` class to be `abstract StringInstrument`. `Guitar` and `Mandolin` inherit from `StringInstrument`.
  * Modified access of fields in `StringInstrument` from `private` to `protected`
  * Added `stringCount` field to `Guitar`
  * Created `Mandolin` class to represent Mandolins.
  * Created `MandolinStyle` enum, which is composed in `Mandolin` class
  * Added `MandolinBuilder`, to build `Mandolin`s
  * Search can refine results based on instrument type.

# Search Functionality
  * no major change needed to be made; The original implementation is now part of `StringInstrument`
  * The original implementation is modified to match the search parameter with the class name
      * this enables searching by instrument type
  * `Guitar` and `Mandolin` override the search functionality by
      1. matching for instrument specific fields,
      2. calling the super-class search implemenation for common fields
  * Advantage
    * No major changes. very easily extensible
  * Disadvantage
    * a match case must be written for every individual class field
  * Relevant Method Signatures:
    ```
    In Inventory.java
      ArrayList<StringInstrument> search(String)
      ArrayList<StringInstrument> search(Collection<StringInstrument>, String)
      ArrayList<StringInstrument> refinedSearch(Collection<StringInstrument>, String) {
    In StringInstrument.java and its subclasses:
      boolean contains(String)
    ```
## Note ##
  * Guitar string count is not searchable because the author considers it too arbitrary a search parameter

# TODO #
  * resolve issues from hw #2

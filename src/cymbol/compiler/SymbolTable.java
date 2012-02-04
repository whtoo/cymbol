package cymbol.compiler;

/***
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic
 * Bookshelf. Copyrights apply to this code. It may not be used to create
 * training material, courses, books, articles, and the like. Contact us if you
 * are in doubt. We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book
 * information.
 ***/
public class SymbolTable {
    public GlobalScope globals = new GlobalScope();

    public SymbolTable() {
        initTypeSystem();
    }

    protected void initTypeSystem() {
        globals.define(new BuiltInTypeSymbol(BuiltInTypeSymbol.INT));
        globals.define(new BuiltInTypeSymbol(BuiltInTypeSymbol.FLOAT));
        globals.define(new BuiltInTypeSymbol(BuiltInTypeSymbol.VOID)); // pseudo-type
    }

    public String toString() {
        return globals.toString();
    }
}

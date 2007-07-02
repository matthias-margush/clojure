/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Common Public License 1.0 (http://opensource.org/licenses/cpl.php)
 *   which can be found in the file CPL.TXT at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Mar 25, 2006 11:42:47 AM */

package clojure.lang;


public class Symbol{
//these must be interned strings!
public final String name;
public final String ns;

public String toString(){
	if(ns != null)
		return ns + "/" + name;
	return name;
}

public Symbol(String name,String ns){
	this.name = name.intern();
	if(ns != null)
		this.ns = ns.intern();
	else
		this.ns = null;
}

public boolean equals(Object o){
	if(this == o)
		return true;
	if(o == null || !(o instanceof Symbol))
		return false;

	Symbol symbol = (Symbol) o;

	//identity compares intended, names are interned
	return name == symbol.name && ns == symbol.ns;
}

public int hashCode(){
	return RT.hashCombine(name.hashCode(),RT.hash(ns));
}

}

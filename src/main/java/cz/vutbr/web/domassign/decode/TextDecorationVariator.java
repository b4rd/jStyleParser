/**
 * 
 */
package cz.vutbr.web.domassign.decode;

import cz.vutbr.web.css.CSSProperty;
import cz.vutbr.web.css.CSSProperty.*;
import cz.vutbr.web.css.Term;
import cz.vutbr.web.css.TermURI;

import java.util.Map;

/**
 * Variator for text-decoration. Grammar:
 * 
 * <pre>
 * ['text-decoration-line' || 'text-decoration-style' || 'text-decoration-color' ]
 * 
 * @author kapy
 */
public class TextDecorationVariator extends Variator {

    public static final int LINE = 0;
    public static final int STYLE = 1;
    public static final int COLOR = 2;

    /*
     * protected String[] names = { "list-style-image", "list-style-type",
     * "list-style-position" };
     */
    public TextDecorationVariator() {
        super(3);
        names.add("text-decoration-line");
        types.add(TextDecorationLine.class);
        names.add("text-decoration-style");
        types.add(TextDecorationStyle.class);
        names.add("text-decoration-color");
        types.add(Color.class);
    }

    @Override
    protected boolean variant(int v, IntegerRef iteration,
            Map<String, CSSProperty> properties, Map<String, Term<?>> values) {

        // we won't use multivalue functionallity
        int i = iteration.get();

        switch (v) {
        case LINE:
            // text-decoration-line
            return genericTermIdent(TextDecorationLine.class, terms.get(i),
                    AVOID_INH, names.get(LINE), properties);
        case STYLE:
            // text-decoration-style
            return genericTermIdent(TextDecorationStyle.class, terms.get(i),
                    AVOID_INH, names.get(STYLE), properties);
        case COLOR:
            // text-decoration-color
            return genericTermIdent(types.get(COLOR), terms.get(i),
                    AVOID_INH, names.get(COLOR), properties)
                    || genericTermColor(terms.get(i), names.get(COLOR),
                    BackgroundColor.color, properties, values);
        default:
            return false;
        }
    }
}

/* MyZulRule.java

        Purpose:
                
        Description:
                
        History:
                Thu Jul 13 21:55:28 CST 2023, Created by rebeccalai

Copyright (C) 2023 Potix Corporation. All Rights Reserved.
*/
package my.pkg;

import org.zkoss.idom.Element;
import org.zkoss.zklinter.Rule;
import org.zkoss.zklinter.ZulFileVisitor;

public class MyZulRule extends Rule {
    @Override
    protected String getDescription() {
        return "My Custom Zul Rule - Found a `<toolbar>` element";
    }

    @Override
    public ZulFileVisitor newZulFileVisitor() {
        return new ZulFileVisitor() {
            @Override
            protected void visitElement(Element node) {
                // insert your code here
                if ("toolbar".equals(node.getLocalName())) {
                    report(node, getDescription());
                }
            }
        };
    }
}

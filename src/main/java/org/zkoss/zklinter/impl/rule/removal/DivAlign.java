package org.zkoss.zklinter.impl.rule.removal;

import org.zkoss.idom.Element;
import org.zkoss.zklinter.*;

public class DivAlign extends Rule {
    @Override
    protected String getDescription() {
        return "align in a div is no longer supported in ZK 10, use css";
    }

    @Override
    protected ZulFileVisitor newZulFileVisitor() {
        return new ZulFileVisitor() {
            @Override
            protected void visitElement(Element node) {
                // insert your code here
                if ("div".equals(node.getLocalName())) {
                    if (node.hasAttribute("align")) {
                        report(node, getDescription());
                    }
                }
            }
        };
    }
}

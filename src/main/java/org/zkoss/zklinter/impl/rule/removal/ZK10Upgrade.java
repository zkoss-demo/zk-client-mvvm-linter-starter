package org.zkoss.zklinter.impl.rule.removal;

import org.zkoss.idom.Element;
import org.zkoss.zklinter.*;

import java.util.List;

/**
 * a collection of rules for all removed attributes since zk 10.0.0
 */
public class ZK10Upgrade extends Rule {

    protected static List<RemovedAttribute> attributeList;

    static {
        attributeList = List.of(
                new RemovedAttribute("autostart", List.of("audio"), "Deprecated since 7.0.0, use autoplay instead."),
                new RemovedAttribute("widths", List.of("box","hbox","vbox"), "Deprecated since 5.0.0, put <cell width> inside instead."),
                new RemovedAttribute("heights", List.of("box","hbox","vbox"), "Deprecated since 5.0.0, put <cell height> inside instead."),
                new RemovedAttribute("timeZone", List.of("calendar"), "Deprecated since 5.0.5, please remove it."),
                new RemovedAttribute("border", List.of("captcha"), "Deprecated since 5.0.4, use frame instead."),
                new RemovedAttribute("align", List.of( "div", "grid", "iframe", "image"), "Deprecated since 5.0/6.0, use CSS instead e.g. text-align, vertical-align."),
                new RemovedAttribute("compact", List.of("datebox"), "Deprecated since 5.0.0, please remove it."),
                new RemovedAttribute("maxsize", List.of("fileupload"), "Deprecated since 5.0.0, specified it in upload"),
                new RemovedAttribute("number", List.of("fileupload"), "Deprecated since 5.0.0, specified it in upload"),
                new RemovedAttribute("native", List.of("fileupload"), "Deprecated since 5.0.0, specified it in upload"),
                new RemovedAttribute("fixedLayout", List.of("grid", "listbox", "tree"), "Since 5.0.0, use sizedByContent instead."),
                new RemovedAttribute("legend", List.of("groupbox"), "Deprecated since 6.0, please remove it."),
                new RemovedAttribute("hspace", List.of("image"), "Deprecated since 6.0.0, use CSS instead."),
                new RemovedAttribute("vspace", List.of("image"), "Deprecated since 6.0.0, use CSS instead.."),
                new RemovedAttribute("hyphen", List.of("label"), "Deprecated since 5.0.0, use CSS instead."),
                new RemovedAttribute("flex", List.of("center","east","north", "south", "west"), "Deprecated since 6.0.2, use hflex or vflex on child components instead"),
                new RemovedAttribute("preloadSize", List.of("grid", "listbox"), "Deprecated since 5.0.8, use <custom-attributes> instead."),
                new RemovedAttribute("checkable", List.of("listitem", "treeitem"), "Deprecated since 8.0.0, please use selectable"),
                new RemovedAttribute("framable", List.of("panel"), "Deprecated since 5.0.6, use border instead."),
                new RemovedAttribute("spans", List.of("row","group", "groupfoot"), "Deprecated since 5.0.0, use <cell spans> instead."),
                new RemovedAttribute("type", List.of("script"), "Deprecated since 5.0.0, text/javascript is always assumed, please remove it."),
                new RemovedAttribute("dynamic", List.of("style"), "Deprecated since 5.0.0, it is decided automatically, please remove it."),
                new RemovedAttribute("treeitemRenderer", List.of("tree"), "Deprecated since 5.0.6, replaced with itemRenderer"),
                new RemovedAttribute("defaultActionOnShow", List.of("window"), "Deprecated since 5.0.0, replaced with action.")
        );
    }

    @Override
    protected String getDescription() {
        return "Check those removed component attributes since ZK 10.0";
    }


    @Override
    protected ZulFileVisitor newZulFileVisitor() {
        return new ZulFileVisitor() {
            @Override
            protected void visitElement(Element node) {
                StringBuilder message = new StringBuilder(); //clear previous messages
                for (RemovedAttribute attribute : attributeList) {
                    if (node.hasAttribute(attribute.getName()) &&
                            attribute.getTags().contains(node.getTagName())) {
                        message.append(String.format("The attribute, %s, in <%s> is no longer supported since ZK 10. ", attribute.getName(), node.getTagName()));
                        message.append(attribute.getDescription());
                    }
                }
                if (message.length() > 0){
                    report(node, message.toString());
                }
            }
        };
    }

}

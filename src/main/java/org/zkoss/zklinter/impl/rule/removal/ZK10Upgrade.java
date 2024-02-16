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
                new RemovedAttribute("autostart", List.of("audio"), "As of release 7.0.0, use autoplay instead."),
                new RemovedAttribute("widths", List.of("box","hbox","vbox"), "As of release 5.0.0, put <cell width> inside instead."),
                new RemovedAttribute("heights", List.of("box","hbox","vbox"), "As of release 5.0.0, put <cell height> inside instead."),
                new RemovedAttribute("timeZone", List.of("calendar"), "As of release 5.0.5, it is meaningless to set time zone for a calendar."),
                new RemovedAttribute("border", List.of("captcha"), "As of release 5.0.4, use frame instead."),
                new RemovedAttribute("align", List.of( "div", "grid", "iframe", "image"), "As of release 5.0/6.0, use CSS instead."),
                new RemovedAttribute("compact", List.of("datebox"), "As of release 5.0.0, it is no longer supported."),
                new RemovedAttribute("maxsize", List.of("fileupload"), "As of release 5.0.0, specified in upload"),
                new RemovedAttribute("number", List.of("fileupload"), "As of release 5.0.0, specified in upload"),
                new RemovedAttribute("native", List.of("fileupload"), "As of release 5.0.0, specified in upload"),
                new RemovedAttribute("fixedLayout", List.of("grid", "listbox", "tree"), "Since 5.0.0, use sizedByContent instead."),
                new RemovedAttribute("legend", List.of("groupbox"), "As of release 6.0, legend no longer used in groupbox."),
                new RemovedAttribute("hspace", List.of("image"), "As of release 6.0.0, use CSS instead."),
                new RemovedAttribute("vspace", List.of("image"), "As of release 6.0.0, use CSS instead.."),
                new RemovedAttribute("hyphen", List.of("label"), "As of release 5.0.0, use CSS instead."),
                new RemovedAttribute("flex", List.of("center","east","north", "south", "west"), "As of release 6.0.2, use hflex or vflex on child component instead"),
                new RemovedAttribute("preloadSize", List.of("grid", "listbox"), "As of release 5.0.8, use custom attributes instead."),
                new RemovedAttribute("checkable", List.of("listitem", "treeitem"), "As of release 8.0.0, please use selectable"),
                new RemovedAttribute("framable", List.of("panel"), "As of release 5.0.6, replaced with border."),
                new RemovedAttribute("spans", List.of("row","group", "groupfoot"), "As of release 5.0.0, use <cell spans> instead."),
                new RemovedAttribute("type", List.of("script"), "As of release 5.0.0, text/javascript is always assumed."),
                new RemovedAttribute("dynamic", List.of("style"), "As of release 5.0.0, it is decided automatically."),
                new RemovedAttribute("treeitemRenderer", List.of("tree"), "As of release 5.0.6, replaced with itemRenderer"),
                new RemovedAttribute("defaultActionOnShow", List.of("window"), "As release of 5.0.0, replaced with action.")
        );
    }

    @Override
    protected String getDescription() {
        return message.toString();
    }

    protected StringBuilder message = new StringBuilder();

    @Override
    protected ZulFileVisitor newZulFileVisitor() {
        return new ZulFileVisitor() {
            @Override
            protected void visitElement(Element node) {
                message = new StringBuilder(); //clear previous messages
                for (RemovedAttribute attribute : attributeList) {
                    if (node.hasAttribute(attribute.getName()) &&
                            attribute.getTags().contains(node.getTagName())) {
                        message.append(String.format("%s in <%s> is no longer supported since ZK 10.", attribute.getName(), node.getTagName()));
                        message.append(attribute.getDescription());
                    }
                }
                if (message.length() > 0){
                    report(node, getDescription());
                }
            }
        };
    }

}

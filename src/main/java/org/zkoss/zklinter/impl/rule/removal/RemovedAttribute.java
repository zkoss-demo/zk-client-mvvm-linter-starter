package org.zkoss.zklinter.impl.rule.removal;

import java.util.List;

/**
 * Class representing removed attributes of ZK components since 10.0.0 and contains help message.
 */
public class RemovedAttribute {
    private String name;
    private List<String> tags;

    /** Hint users on how to handle this removed attribute */
    private String description;

    public RemovedAttribute(String name, List<String> tags, String description) {
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

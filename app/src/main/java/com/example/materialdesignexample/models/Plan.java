package com.example.materialdesignexample.models;

/**
 * Created by Amaury Esparza on 08/03/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class Plan {

    private String name;
    private Integer space;
    private Integer collaborators;
    private Integer privateRepos;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The space
     */
    public Integer getSpace() {
        return space;
    }

    /**
     *
     * @param space
     * The space
     */
    public void setSpace(Integer space) {
        this.space = space;
    }

    /**
     *
     * @return
     * The collaborators
     */
    public Integer getCollaborators() {
        return collaborators;
    }

    /**
     *
     * @param collaborators
     * The collaborators
     */
    public void setCollaborators(Integer collaborators) {
        this.collaborators = collaborators;
    }

    /**
     *
     * @return
     * The privateRepos
     */
    public Integer getPrivateRepos() {
        return privateRepos;
    }

    /**
     *
     * @param privateRepos
     * The private_repos
     */
    public void setPrivateRepos(Integer privateRepos) {
        this.privateRepos = privateRepos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

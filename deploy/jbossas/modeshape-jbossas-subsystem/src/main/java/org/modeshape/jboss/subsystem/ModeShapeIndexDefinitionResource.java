/*
 * ModeShape (http://www.modeshape.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.modeshape.jboss.subsystem;

import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.registry.ManagementResourceRegistration;

public class ModeShapeIndexDefinitionResource extends SimpleResourceDefinition {
    protected final static ModeShapeIndexDefinitionResource INSTANCE = new ModeShapeIndexDefinitionResource();

    private ModeShapeIndexDefinitionResource() {
        super(ModeShapeExtension.INDEX_DEFINITION_PATH, ModeShapeExtension.getResourceDescriptionResolver(ModelKeys.REPOSITORY,
                                                                                                          ModelKeys.INDEX),
              AddIndexDefinition.INSTANCE, RemoveIndexDefinition.INSTANCE);
    }

    @Override
    public void registerAttributes( ManagementResourceRegistration resourceRegistration ) {
        super.registerAttributes(resourceRegistration);
        IndexDefinitionWriteAttributeHandler.INSTANCE.registerAttributes(resourceRegistration);
    }
}
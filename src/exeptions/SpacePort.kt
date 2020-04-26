package exeptions

import exeptions.customexceptions.*

object SpacePort {
    fun investigateSpace(spaceCraft: SpaceCraft) {
        try {
            spaceCraft.launch()
        } catch (exception: SpaceCraftException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.overhaul()
        } catch (exception: AliensAttackException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.land()
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }

    fun testSetup(spaceCraft: SpaceCraft):Boolean = try {
        spaceCraft.launch()
        true
    } catch (exception: SpaceCraftException) {
        false
    } finally {
        spaceCraft.land()
    }


}
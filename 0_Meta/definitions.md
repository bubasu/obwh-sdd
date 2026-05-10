# Definitions

The following information is intended to help with Specification Driven Development.

## Terms

- **Product**: an artifact that can be experienced by users
- **System**:
    - a **System** is the technical foundation of a **Product**
    - a **Product** is realized using a **System**
- **Vision**: describes a goal, the end result of a successful development
- **Product Vision**: describes the **Vision** of a **Product**
- **System Vision**: describes the **Vision** of a **System**
- **Design**:
    - describes an intermediate state on the way of development towards the **Vision**
    - at the end of development, the **Design** corresponds to the **Vision**
- **Product Design**: describes the **Design** of a **Product**
- **System Design**: describes the **Design** of a **System**
- **Implementation**:
    - the runnable realization of a **System Design**
    - at the end of development, this is the runnable realization of the **System Vision**
    - and thus also a runnable realization of the **Product Vision**
- **Story**:
    - a development step, an increment
    - a **Product Design** moves towards the **Product Vision** in **Story** increments
    - a **System Design** moves towards the **System Vision** in **Story** increments
    - an **Implementation** moves towards the **System Vision** in **Story** increments

## Directory Structure and Documents

- Directory 0_Meta
    - contains document definitions.md:
        - definitions of the terms used
        - description of a directory structure and the documents it contains
        - directory structure and documents are based on the defined terms
- Directory 1_Vision/Product
    - contains documents for the **Product Vision**
- Directory 1_Vision/System
    - contains documents for the **System Vision**
- Directory 2_Design/Product
    - contains documents for the **Product Design**
- Directory 2_Design/System
    - contains documents for the **System Design**
- Directory 3_Implementation:
    - contains guideline.md files for each technology used
    - contains all artifacts of the **Implementation**
- Directory 4_Stories
    - contains a directory for each **Story** with all documents belonging to the story

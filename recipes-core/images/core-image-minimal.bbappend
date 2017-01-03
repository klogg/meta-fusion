# Add Docker and Go
IMAGE_INSTALL_append = " \
    kernel-module-aufs \
    kernel-modules \
    docker \
    cronie \
    dropbear \
    aufs-util \
"

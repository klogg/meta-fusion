DESCRIPTION = "FUSION recipe for AArch64 kernels"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Skip processing of this recipe if it is not explicitly specified as the
# PREFERRED_PROVIDER for virtual/kernel. This avoids errors when trying
# to build multiple virtual/kernel providers, e.g. as dependency of
# core-image-rt-sdk, core-image-rt.
python () {
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel", True) != "linux-fusion":
        raise bb.parse.SkipPackage("Set PREFERRED_PROVIDER_virtual/kernel to linux-fusion to enable it")
}

# 4.14.1 tag from
SRCREV_machine ?= "780a781dd6f1af9dfac15b8eeba1cb678c9fc380"

KMETA = "kernel-meta"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=http;name=machine;branch=linux-4.14.y"

LINUX_VERSION ?= "4.14.1"
LINUX_VERSION_EXTENSION_append = "-custom"

LINUX_KERNEL_TYPE = "tiny"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "xenaarch64"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://defconfig"


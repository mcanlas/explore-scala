package com.htmlism

sealed trait KnowledgeDependency {

}

class RootDependency(implicit reg: Registry) extends KnowledgeDependency

class DependsOn(xs: KnowledgeDependency*)(implicit reg: Registry) extends KnowledgeDependency

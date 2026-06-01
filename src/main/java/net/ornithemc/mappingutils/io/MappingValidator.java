package net.ornithemc.mappingutils.io;

import net.ornithemc.mappingutils.io.Mappings.ClassMapping;
import net.ornithemc.mappingutils.io.Mappings.FieldMapping;
import net.ornithemc.mappingutils.io.Mappings.Mapping;
import net.ornithemc.mappingutils.io.Mappings.MethodMapping;
import net.ornithemc.mappingutils.io.Mappings.ParameterMapping;
import net.ornithemc.mappingutils.io.Mappings.LocalVariableMapping;

public interface MappingValidator {

	public static final MappingValidator ALWAYS = new MappingValidator() {

		@Override
		public boolean validate(ClassMapping c) {
			return true;
		}

		@Override
		public boolean validate(FieldMapping f) {
			return true;
		}

		@Override
		public boolean validate(MethodMapping m) {
			return true;
		}

		@Override
		public boolean validate(ParameterMapping p) {
			return true;
		}

		@Override
		public boolean validate(LocalVariableMapping v) { return true; }
	};
	public static final MappingValidator NEVER = new MappingValidator() {

		@Override
		public boolean validate(ClassMapping c) {
			return false;
		}

		@Override
		public boolean validate(FieldMapping f) {
			return false;
		}

		@Override
		public boolean validate(MethodMapping m) {
			return false;
		}

		@Override
		public boolean validate(ParameterMapping p) {
			return false;
		}

		@Override
		public boolean validate(LocalVariableMapping v) { return false; }
	};

	default boolean validate(Mapping mapping) {
		switch (mapping.target()) {
		case CLASS:
			return validate((ClassMapping)mapping);
		case FIELD:
			return validate((FieldMapping)mapping);
		case METHOD:
			return validate((MethodMapping)mapping);
		case PARAMETER:
			return validate((ParameterMapping)mapping);
		case LOCAL_VARIABLE:
			return validate((LocalVariableMapping)mapping);
		default:
			return false;
		}
	}

	boolean validate(ClassMapping c);

	boolean validate(FieldMapping f);

	boolean validate(MethodMapping m);

	boolean validate(ParameterMapping p);

	boolean validate(LocalVariableMapping v);
}
